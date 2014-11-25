#!/bin/bash

function log {
    LOG_URL="http://localhost:9000/messages"    
    if [ -n "$*" ]; then
        LOG_MSG="$*"
    else
        LOG_MSG=""
        while read data # This reads a string from stdin and stores it in a variable
        do
            LOG_MSG="${LOG_MSG}${data}\n"
        done
    fi

    curl -X POST -H 'Content-Type: application/json' -d "{\"message\": \"${LOG_MSG}\"}" ${LOG_URL} > /dev/null 2>&1
}

log $*
feajfewaoi 2>&1 | log
ls /tmp | log
