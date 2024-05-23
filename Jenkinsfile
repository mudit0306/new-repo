pipeline {
    agent any
    stages{
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