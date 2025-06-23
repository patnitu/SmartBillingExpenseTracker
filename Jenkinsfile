pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'github-creds1', url: 'https://github.com/patnitu/SmartBillingExpenseTracker.git', branch: 'master'
            }
        }

        stage('Build Services') {
            steps {
                sh 'docker-compose build'
            }
        }

        stage('Start Services') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
