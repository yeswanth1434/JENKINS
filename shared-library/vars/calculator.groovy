def add(x,y) {
  echo " sum of ${x} and ${y} is ${x+y}"
}
def mul(x,y) {
  echo " sum of ${x} and ${y} is ${x*y}"
}




in jenkins pipeline:
@Library('sharelibs') _

pipeline {
    agent any

    stages {
        stage('add') {
            steps {
                script {
                    calculator.add(22,33)
                    calculator.mul(7,8)
                }
            }
        }
    }
}
