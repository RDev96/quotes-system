<!-- PROJECT LOGO -->
<br />
<div align="center">

  <h3 align="center">quotes-system</h3>

  <p align="center">
    El sistema de creación de cotizaciones para productos importados está diseñado para facilitar la gestión y el acceso a información de precios. Contiene dos módulos principales: uno para usuarios finales y otro para administradores.
  </p>
</div>



<!-- ABOUT THE PROJECT -->
## Acerca del proyecto

Arquitectura: El sistema se basa en una arquitectura de cliente-servidor, con un robusto backend desarrollado en Java utilizando el framework Spring Boot. Se emplea JPA para la gestión de la persistencia de datos y Spring Security para garantizar la protección de la aplicación, utilizando JWT tokens para la autenticación de usuarios.

Frontend: La interfaz de usuario está construida con TypeScript y el framework Angular, lo que permite una experiencia interactiva y dinámica. Bootstrap se utiliza para garantizar un diseño responsivo y atractivo, facilitando la navegación para los usuarios.

Base de Datos: Se implementa PostgreSQL como sistema de gestión de bases de datos, utilizando pgAdmin 4 para la administración y visualización de los datos.

Módulos:

Usuarios Finales: Pueden explorar productos importados, solicitar cotizaciones personalizadas.

Administradores: Tienen herramientas para supervisar las cotizaciones y analizar el comportamiento de los usuarios.

Este sistema no solo mejora la eficiencia en la creación de cotizaciones, sino que también ofrece un entorno seguro y amigable para todos los usuarios involucrados.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Construido con

* [![Angular][Angular.io]][Angular-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]
* [![Spring][Spring.com]][Spring-url]
* [![Java][Java.com]][Java-url]
* [![Typescript][Typescript.com]][Typescript-url]
* [![Node][Node.com]][Node-url]
* [![Postgresql][Postgresql.com]][Postgresql-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Empezando

Para hacer uso tanto del aplicativo tanto en su apartado back end , front end y base de datos debes tomar las siguientes consideraciones de uso.

### Pre-requisitos


1. Versiones para uso Back-End
*	Java 11
*	Spring 2.6.13

2. Versiones para uso Front-End
* Angular CLI 14.1.3
* Node (npm) 8.15.1
* TypeScript 4.1.3
   
3. Versiones para uso Base de datos
* PostgreSQL 17.0-1

### Instalacion Angular

1. Clonar el repositorio.
   ```sh
   git clone https://github.com/RDev96/quotes-system.git
   ```
2. Moverse a la rama de desarrollo
   ```sh
   git ckeckout develop
   ```
3. Para hacer uso del proyecto Angular ubicado en la carpeta FRONT END ejecutar el siguiente comando
   ```sh
   npm install --legacy-peer-deps=true
   ```
4. Para iniciar el proyecto Angular ejecuta el comando
   ```js
   npm start
   ```


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Uso

Para poder hacer un mejor uso de el aplicativo puedes consultar la documentacion tecnica y el manual de usuario que se encuentran en la carpeta Documentacion en este repositorio.

_Para ver el uso del aplicativo, favor ir a la documentacion de usuario [Documentacion](https://github.com/RDev96/quotes-system/tree/main/DOCUMENTOS)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[Angular.io]: https://img.shields.io/badge/Angular_Cli-V_14.1.3-DD0031?style=for-the-badge&logo=angular&logoColor=DD0031
[Angular-url]: https://angular.io/
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[Spring.com]: https://img.shields.io/badge/Spring-V_2.6.13-6cb52d?style=for-the-badge&logo=spring&logoColor=6cb52d
[Spring-url]: https://jquery.com](https://spring.io/

[Typescript.com]: https://img.shields.io/badge/Typescript-V_4.1.3-20232A?style=for-the-badge&logo=typescript&logoColor=white
[Typescript-url]: https://www.typescriptlang.org/
[Java.com]: https://img.shields.io/badge/Java-V_11-20232A?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/es/
[Node.com]: https://img.shields.io/badge/Node-V_8.15.1-6cb52d?style=for-the-badge&logo=Node.js&logoColor=6cb52d
[Node-url]: https://www.java.com/es/
[Postgresql.com]: https://img.shields.io/badge/Postgresql-V_17.0.1-20232A?style=for-the-badge&logo=postgresql&logoColor=white
[Postgresql-url]: https://www.postgresql.org/

