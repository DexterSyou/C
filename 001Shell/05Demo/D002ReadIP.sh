#!/bin/sh
#

read -p "Please input your IP Address : "  v_ip
echo "Your IP Address is : " ${v_ip}

ping -Wl -cl ${v_ip} &>/dev/null
#ping ${v_ip} &>/dev/null
if [ 0 -eq $? ]; then
  echo "${v_ip} address ping successully" 
else
  echo -e "\033[31m ${v_ip} address ping fail \033[0m"
fi
