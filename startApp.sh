#!/bin/sh
## Environment Vars read by application
export DATABASE_URL='postgres://investment:invest@localhost:5432/investment'
export MIGRATE_DB=true
export BUILD_TARGET_ID='local'

## Local vars
SERVER_PORT=8098

./grailsw run-app -Dserver.port=$SERVER_PORT -Duser.timezone=UTC --stacktrace
