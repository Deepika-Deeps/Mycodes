pipieline {
    agent any
    environment {
        USER_NAME=Deepika
        USER_ID= 644
    } 
    stages(Employee){
        stage(Details){
            steps{
                echo "Name = ${env.USER_NAME}"
                echo "id = ${env.USER_ID}"
            }
        }
    }
    