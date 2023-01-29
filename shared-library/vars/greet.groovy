def call (name) {
  echo "Hi ${name},welcome"
}


in jenkins pipeline :

 @Library('sharelibs') _

 pipeline {
   agent any
 	    stages {
          stage('Hello') {
             steps {
                 greet('yeswanth')
             }
          }
      }
 }
