#! /usr/bin/python

import os
import subprocess
import sys

TEST_DIR = os.path.join(os.path.curdir, "tests")
DEVNULL = open(os.devnull, 'wb')

class Test:
    def __init__(self, name, compile_success=True, execute=False):
        self.name = name
        self.compile_success = compile_success
        self.execute = execute

def get_main_class_name(file_name):
    fin = open(file_name, "r")
    first = True
    for line in fin:
        for token in line.split():
            if not first:
                return token.split("{")[0]
            else:
                first = False
    return None

def test_compile(test_category, file_name):
    return subprocess.call(["java", "-jar", "mjc.jar", os.path.join(TEST_DIR, test_category, file_name)], stdout=DEVNULL, stderr=DEVNULL)

def test_execute(test_category, file_name):
    main_class = get_main_class_name(os.path.join(TEST_DIR, test_category, file_name))
    ret_code = subprocess.call(["java", "-jar", "jasmin.jar", main_class+".j"], stdout=DEVNULL, stderr=DEVNULL)
    if ret_code:
        return False
    res = True
    ret_code = subprocess.call(["java", main_class], stdout=open(file_name+".tmp", "w"), stderr=DEVNULL)
    if ret_code:
        res = False
    lines1 = open(os.path.join(TEST_DIR, test_category, file_name[:-5])+".out", "r").readlines()
    lines2 = open(file_name+".tmp", "r").readlines()
    
    if (len(lines1) != len(lines2)):
        res = False
    else:
        for i in xrange(len(lines1)):
            if lines1[i] != lines2[i]:
                res = False
    if os.path.isfile(file_name+".tmp"):
        os.remove(file_name+".tmp")
    return res

test_categories = [ #Test("compile"),
                    #Test("noncompile", compile_success=False),
                    Test("execute", execute=True)]

print "Starting build..."
build_error = subprocess.call("ant", stdout=DEVNULL)
if build_error:
    exit(build_error)
print "Build successfull"

print "Starting tests..."
print ""

success = 0
fail = 0
for test_category in test_categories:
    print test_category.name + ":"
    test_files = os.listdir(os.path.join(TEST_DIR, test_category.name))
    for test_file in test_files:
        if not test_file.endswith(".java"):
            continue
        print ("\t" + test_file + "..."),
        ret_code = test_compile(test_category.name, test_file)
        if bool(ret_code) != test_category.compile_success:
            if test_category.execute and not test_execute(test_category.name, test_file):
                fail += 1
                print "Failed"
            else:
                success += 1
                print "Succeeded"
        else:
            fail += 1
            print "Failed"
    print ""

print "Failed tests: " + str(fail)
print "Successful tests: " + str(success)
print ""
print "Removing .j files..."
subprocess.call("rm -r *.j", shell=True)
subprocess.call("rm -r *.class", shell=True)
