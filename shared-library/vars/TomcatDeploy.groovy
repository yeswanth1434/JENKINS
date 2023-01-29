def call (ip,creds,user) {
   sshagent(["${creds}"]) {
       sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat9/webapps"
       sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
       sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
   }
}



IN JENKINS PIPELINE :

@Library('sharelibs') _

pipeline {
    agent any

    stages {
        stage('tomcat deploy') {
            steps {
                TomcatDeploy('172.31.6.93','tomcat-creds','ec2-user')
            }
        }
    }
}
