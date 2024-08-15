#!/bin/bash
set -e

dir=javaserver
if [ -d "${dir}" ]; then
    echo "compiling in ${dir}."
    cd  "${dir}";  
    ant compile; ant jar ; cd ..
fi

dir=javaclient
if [ -d "${dir}" ]; then
    echo "compiling in ${dir}."
    cd  "${dir}";  
    ant compile; ant jar ; cd ..
fi

#ls nonexisting_dir
#####################################
echo "checking docker installation"
if command -v docker &> /dev/null; then
   echo "Found docker installation"
else
   echo "docker, Installation not found. Please install/set docker!!"
   exit 1
fi

echo "start docker build"
dir=javaserver
if [ -d "${dir}" ]; then
    echo "creating docker immage in ${dir}."
    cd  "${dir}";
    docker build -t linxitcld/linxits_jtcpserver .  ; cd ..
fi

dir=javaclient
if [ -d "${dir}" ]; then
    echo "creating docker immage in ${dir}."
    cd  "${dir}";
    docker build -t linxitcld/linxits_jtcpclient .  ; cd ..
fi
