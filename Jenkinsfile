pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building now'
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'aws lambda update-function-code --function-name ssm-lambda --zip-file fileb://backoffice-order-service-lambda-1.1-SNAPSHOT-jar-with-dependencies.jar'
            }
        }
    }
}