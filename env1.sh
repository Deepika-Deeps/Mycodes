pipeline {
    agent any
    stages {
        stage('variales') {
            steps {
                sh 'env | sort '
            }
        }
    }
}