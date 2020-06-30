#!/usr/bin/env bash
curDir=$(cd `dirname $0`;pwd)
projectDir=$(cd ${curDir}/..;pwd)
PYTHON_VENV=/Users/wunan/conda/bin/activate
source ${PYTHON_VENV}
cd ${projectDir}/lekima-pysdk
export FLASK_APP=lekima_service.py
flask run