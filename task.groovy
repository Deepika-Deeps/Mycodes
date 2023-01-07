pipeline {
    agent any
    stages {
        stage('Git checkout stage')
        {
            steps {
                git credentialsId: 'github', url: 'https://github.com/valaxyTech/hello-worl.git'
                 echo "git checkout is successfull...."
                git clone https://github.com/valaxyTech/hello-worl.git
                echo "pulled the code...."
            }
        }
        stage('Maven Built stage')
        {
            steps {
                mvn clean install
                echo " Maven is installed...."
            }
        }
    }
}