pipeline{
    agent any
    environment {
        DIRECTORY_PATH= "User\\Code"
        TESTING_ENVIRONMENT= "VirtualBox"
        PRODUCTION_ENVIRONMENT= "Darryl"
    }
    stages{
        stage('Build'){
            steps{
                echo "fetch the source code from the directory path $DIRECTORY_PATH"

                echo "compile the code and generate any necessary artifacts"
            }
        }
        stage('Test'){
            steps{
                echo "unit tests"

                echo "integration tests"
            }
        }
        stage('Code Quality Check'){
            steps{
                echo "check the quality of the code"
            }
        }
        stage('Deploy'){
            steps{
                echo "deploy the application to a testing environment, $TESTING_ENVIRONMENT"
            }
        }
        stage('Approval'){
            steps{
                sleep 10
            }
        }
        stage('Deploy to Production'){
            steps{
                echo "Deploying to production environment $PRODUCTION_ENVIRONMENT"
            }
        }
    }
}
