pipeline {

    agent any
    stages {
        stage('SCM Checkout') {

            steps {

                echo 'Checkout'
                git 'https://github.com/Nagamathan/WebApp-SOBI.git'

            }

        }
        stage('Build') {

            steps {

                echo 'Building'
                bat label: '', script: 'mvn clean package'

            }
            

        }
		stage('Email Notification'){
		
			steps {
				   emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            }
			
        }
		stage('Test') {

            steps {

                echo 'Testing'
				bat label: '', script: 'mvn verify'

            }

        }
		stage('Test Email Notification'){
		
			steps {
				   emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Test ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            }
			
        }		
		stage('Sanity check') {

			steps {

				input "Proceed with Deployment environment. Did you approve?"

			}

		}
        stage('Deploy') {

            steps {

                echo 'Deployment Started'
				echo 'Deploying the War files to tomcat server http://localhost:9898/'
                bat label: '', script: '''echo %CD%
                copy target\\*.war %DEPLOY_HOME%\\webapps\\'''
                  }

        }

    }

}
