pipeline {
    agent any

    environment {
        DOCKER_REGISTRY = "gcr.io"  // Your GCR registry URL
        IMAGE_NAME = "frontend" // Your Docker image name
        //image2 = "backend"
        //image3 = "mysql"
        TAG = "latest"  // Tag for your Docker image
        GCP_PROJECT_ID = "jagriti-411012"  // Your GCP project ID
        GCP_SERVICE_ACCOUNT_KEY = credentials('GCP_ID')  // Jenkins credentials for GCP service account key file
    }
       stages {
        stage('Test the Scripting'){
            steps{
                 myShared()
            }
        }
    
   
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: '1', url: 'https://github.com/JagritiDubey123/docker-project-123.git'
            }
        }
    
        // stage('Cleanup Workspace') {
        //     steps {
        //         deleteDir()
        //     }
        // }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    sh "docker build -f FrontEnd/Dockerfile ."
                    sh "docker build -f backend/Dockerfile ."
                   // sh "docker build -f mysql/Dockerfile ."
                }
            }
        }

        stage('Push Docker Image to GCR') {
            steps {
                script {
                    // Authenticate with GCP
                    withCredentials([file(credentialsId: 'GCP_ID', variable: 'GCP_SERVICE_ACCOUNT_KEY_FILE')]) {
                        sh "gcloud auth activate-service-account --key-file=${GCP_SERVICE_ACCOUNT_KEY_FILE}"
                    }

                    // Tag Docker image with GCR URL
                    sh "docker tag ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${IMAGE_NAME}:${TAG} ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${IMAGE_NAME}:${TAG}"
                     //sh "docker tag ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image3}:${TAG} ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image2}:${TAG}"
                    // sh "docker tag ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image2}:${TAG} ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image3}:${TAG}"

                    // Push Docker image to GCR
                    sh "docker push ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${IMAGE_NAME}:${TAG}"
                    // sh "docker push ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image2}:${TAG}"
                   //  sh "docker push ${DOCKER_REGISTRY}/${GCP_PROJECT_ID}/${image3}:${TAG}"
                }
            }
        }
    }
}
