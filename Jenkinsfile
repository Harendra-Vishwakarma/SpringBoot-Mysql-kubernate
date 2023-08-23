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
               sh "docker build -t springboot-mysql-k8s:1.0 ."
            }
        }
         stage("docker image bused on docker hub"){
            steps{
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubUser')]) {
               sh "docker login -u ${env.dockerhubUser} -p ${env.dockerhubPass}"
               sh "docker tag springapp ${env.dockerhubUser}/springboot-mysql-k8s:1.0"
               sh "docker push ${env.dockerhubUser}/springboot-mysql-k8s:1.0"
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
