pipeline {
    agent any
    stages {
        stage ('1 choice') {
            when {
                expression  { choice =='1'}
            }
            steps {
                sh echo " Hello, choice 1!"
            }
        }
        stage ('2 choice') {
            when {
                expression { choice =='2'}
            }
            steps {
                sh echo " Hello, choice 2!"
            }
        }
        stage ('3 choice') {
            when {
                expression { choice =='3'}
                }
                steps {
                    sh echo " Hello ,choice 3!
                }
            }
        }
    }
}