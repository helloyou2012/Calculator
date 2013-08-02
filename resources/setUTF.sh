#!/bin/bash

find ./ -type f -name "*.java"|while read line ;

do
    echo $line
    iconv -f GB18030 -t UTF-8 $line > ${line}.utf8
    mv $line ${line}.18030
    mv ${line}.utf8 $line
done
find ./ -type f -name "*.18030" -exec rm -f {} \;