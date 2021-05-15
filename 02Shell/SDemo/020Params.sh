#! /bin/sh

username0=
echo "username0 has been declared, but is set to null."
echo "username0 = ${username0-`whoami`}"

echo
echo username1 has not been declared.
echo "username1 = ${username1-`whoami`}"

echo
username2=
echo "username2 has been declared, but is set to null."
echo "username2 = ${username2:-`whoami`}"

echo "--------------------------------"
echo "variable="
variable=
echo "${variable-0}"
echo "${variable:-1}"
#
unset variable
echo "unset variabel ..."
echo "${variable-2}"
echo "${variable:-3}"

exit 0

