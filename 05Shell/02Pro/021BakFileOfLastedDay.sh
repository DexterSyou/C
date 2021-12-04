#!/bin/bash

BACKUPFILE=backup-$(date +%m-%d-%Y)

archive=${1:-$BACKUPFILE}

tar cvf - `find . -mtime -l -type f -print` > $archive.tar

exit 0
