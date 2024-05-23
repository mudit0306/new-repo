pipeline {
    agent any
    stages{
        stage("checkout"){
            steps{
                git branch: 'main', url: 'https://github.com/mudit0306/new-repo.git'
            }
        }
        stage("build"){
            steps{
                bat './gradlew test'
            }
        }
        stage("capture"){
            steps{
                junit stdioRetention: '', testResults: '**/test-results/test/TEST*.xml'
            }
        }
    }
    
}