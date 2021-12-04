#!/bin/bash	

#if cmp a b &> /dev/null
#then echo "Files a and b are identical."
#else echo "Files a and b differ."
#fi

if grep -q Bash file
then echo "File contains at least one occurrence of Bash."
fi

if COMMAND_WHOSE_EXIT_STATUS_IS_0_UNLESS_ERROR_OCCURRED
then echo "Command succeeded."
else echo "Command failed."
fi



