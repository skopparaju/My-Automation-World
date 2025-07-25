pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/skopparaju/My-Automation-World.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}