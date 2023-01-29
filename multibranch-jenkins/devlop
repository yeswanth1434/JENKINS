pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('git checkout') {
            when{
                branch 'feature1'
            }
            steps {
                git branch: 'main', credentialsId: 'git-creds', url: 'https://github.com/yeswanth1434/multibranch-jenkins'
            }
        }
        stage('maven build') {
            when{
                branch 'develop'
            }
            steps {
                sh "mvn clean package"
            }
        }
        stage('Tomcat Deploy - dev') {
            when{
                branch 'develop'
            }
            steps {
                echo "Deploying to developing"
            } 
        }
    }
}
