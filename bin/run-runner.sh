#!/usr/bin/env bash
curDir=$(cd `dirname $0`;pwd)
projectDir=$(cd ${curDir}/..;pwd)
PYTHON_VENV=/Users/wunan/conda/bin/activate
source ${PYTHON_VENV}
cmd="python ${projectDir}/lekima-pysdk/runner.py $@"
echo ${cmd}
${cmd}