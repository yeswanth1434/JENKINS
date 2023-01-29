def call (ip,creds,user) {
   sshagent(["${creds}"]) {
       sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat9/webapps"
       sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
       sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
   }
}



IN JENKINS PIPELINE :

stage('tomcat deploy') {
  steps {
    sshagent(['tomcat-creds']) {
      sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@172.31.6.93:/opt/tomcat9/webapps"
      sh "ssh ec2-user@172.31.6.93 /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ec2-user@172.31.6.93 /opt/tomcat9/bin/startup.sh"
    }
  }
}
