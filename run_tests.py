#! /usr/bin/python

import os
import subprocess

class Test:
    def __init__(self, name, compile_success):
        self.name = name
        self.compile_success = compile_success

TEST_DIR = os.path.join(os.path.curdir, "tests")
DEVNULL = open(os.devnull, 'wb')

test_categories = [ Test("compile", True), Test("noncompile", False)]

print "Starting build..."
build_error = subprocess.call("ant", stdout=DEVNULL)
if build_error:
    exit(build_error)
print "Build successfull"

print "Starting tests..."
print ""

success = 0
fail = 0
for test in test_categories:
    print test.name + ":"
    test_files = os.listdir(os.path.join(TEST_DIR, test.name))
    for test_file in test_files:
        print ("\t" + test_file + "..."),
        ret_code = subprocess.call(["java", "-jar", "mjc.jar", os.path.join(TEST_DIR, test.name, test_file)], stdout=DEVNULL, stderr=DEVNULL)
        if bool(ret_code) != test.compile_success:
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
