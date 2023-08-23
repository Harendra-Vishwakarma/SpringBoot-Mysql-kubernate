pipeline{
    agent any
    tools{
        maven "maven"
    }
    
    stages{
        stage("code"){
            steps{
                git url:'https://github.com/Harendra-Vishwakarma/SpringBoot-Mysql-kubernate.git', branch:"main"
            }
        }
         stage("Build"){
            steps{
              sh "mvn -Dmaven.test.skip=true clean package"
               sh "docker build -t springboot-k8s ."
            }
        }
         stage("docker image bused on docker hub"){
            steps{
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubUser')]) {
               sh "docker login -u ${env.dockerhubUser} -p ${env.dockerhubPass}"
               sh "docker tag springboot-k8s ${env.dockerhubUser}/springboot-k8s:latest"
               sh "docker push ${env.dockerhubUser}/springboot-k8s:latest"
              }
            }
        }
         stage("Run MYSQL on kubernets (minikube)"){
            steps{
              sh "kubectl apply -f db-deployment.yaml"
            }
        }
         stage("deplo on kubernets (minikube)"){
            steps{
              sh "kubectl apply -f app-deployment.yaml"
            }
        }
    }
}
