#!/bin/bash
# stoping apache
rm -rf /var/www/html/*
service tomcat8 stop
