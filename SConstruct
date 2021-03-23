# SCons Build System descriptor for CS151 Java Projects

from os import environ

env = Environment( ENV = environ )
arg = ARGUMENTS.get

env.folder = arg("folder")

env.target_folder = "classes"
env.source_folder = "src"

env.bin_manifest = "MANIFEST.txt"
env.bin_target = "bin/%s.jar" % env.folder

SConscript("%s/SCSub" % env.folder, 'env')
