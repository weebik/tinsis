<a id="readme-top"></a>


<!-- PROJECT SHIELDS -->
<div align="center">

[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

</div>

<br />
<div align="center">
  <a href="https://github.com/weebik/Tinsis">
    <img src="images/preview.png" alt="Logo" width="300" height="400">
  </a>

<h3 align="center">TINSIS</h3>
  <p align="center">
    Siple Space Invaders like game made with JavaSwing
    <br />
    <a href="https://github.com/weebik/tinsis/issues/new?template=Blank+issue">Report Bug</a>
    ·
    <a href="https://github.com/weebik/tinsis/issues/new?template=Blank+issue">Request Feature</a>
  </p>
</div>
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#game-description">Game Description</a>
      <ul>
        <li><a href="#controls">Controls</a></li>
        <li><a href="#how-to-play">How to play?</a></li>
        <li><a href="#structure">Project Structure</a></li>
      </ul>
    </li>
    <li>
      <a href="#contributing">Contributing</a>
      <ul>
        <li><a href="#reporting-issues">Reporting issues</a></li>
        <li><a href="#suggesting-improvements">Suggesting improvements</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#todo">Todo</a></li>
  </ol>
</details>


## Game Description
Tinsis is similar to the classic Space Invaders game, and the theme is Star Wars. In the game, the player controls a spaceship that can move and shoot lasers at enemies. The goal is to avoid enemy attacks in order to survive as long as possible and score as many points as possible.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Controls
> <kbd>W</kbd> or <kbd>↑</kbd> &rarr; Move up</br>
> <kbd>A</kbd> or <kbd>←</kbd> &rarr; Move to left</br>
> <kbd>S</kbd> or <kbd>↓</kbd> &rarr; Move down</br>
> <kbd>D</kbd> or <kbd>→</kbd> &rarr; Move to right</br>
<kbd>Space</kbd> &rarr; Shoot</br>
> <kbd>R</kbd> &rarr; Reset</br>
> <kbd>Q</kbd> &rarr; Exit</br>
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## How to play?
**Be sure you have openjdk 19.0.2 or newer versions**
1) Copy repository from github
2) Run:
```bash
  ./tinsis.sh
```
3) Enjoy playing :)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Structure
```
Tinsis/
├── images
├── lib/
│   ├── Board.java
│   ├── Commons.java
│   ├── Sprite.java
│   ├── Tie.java
│   ├── TieLaser.java
│   ├── Xwing.java
│   └── XwingLaser.java
├── src/
│   ├── assets
│   └── Tinsis.java
└── tinsis.sh
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributing
Thank you for your interest in contributing to my project! Your feedback and suggestions are invaluable in making this app better. Below are some ways you can contribute:

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Reporting Issues  
If you find any bugs or issues, please let me know by creating a [GitHub issue](https://github.com/weebik/tinsis/issues/new?template=Blank+issue). When reporting, try to include:  
- A clear description of the issue.  
- Steps to reproduce the problem.  
- Screenshots or error messages, if applicable.  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Suggesting Improvements  
Your ideas on how to improve the project are always welcome! Feel free to:  
- Suggest ways to optimize the code for better performance.  
- Propose changes to make the code more readable and maintainable.  
- Recommend new features or enhancements that align with the project's goals. You can do that via [Request feature](https://github.com/weebik/tinsis/issues/new?template=Blank+issue) form.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## License
This projects uses **MIT License.** Read more at [LICENSE](https://github.com/weebik/tinsis/blob/master/LICENSE.txt). </br>
**Assets do not belong to me** and aren't covered by license.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Krystian Ćwikliński - krystian.samaa@gmail.com

Project Link: [https://github.com/weebik/Tinsis](https://github.com/weebik/Tinsis)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Todo:
- Better colisions
- Menu and score table
- Boosters from enemies
- Style and better graphics
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- URLs -->
[contributors-shield]: https://img.shields.io/github/contributors/weebik/Tinsis.svg?style=for-the-badge
[contributors-url]: https://github.com/weebik/Tinsis/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/weebik/Tinsis.svg?style=for-the-badge
[forks-url]: https://github.com/weebik/Tinsis/network/members
[stars-shield]: https://img.shields.io/github/stars/weebik/Tinsis.svg?style=for-the-badge
[stars-url]: https://github.com/weebik/Tinsis/stargazers
[issues-shield]: https://img.shields.io/github/issues/weebik/Tinsis.svg?style=for-the-badge
[issues-url]: https://github.com/weebik/Tinsis/issues
[license-shield]: https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge
[license-url]: https://img.shields.io/github/license/weebik/Tinsis%2Ffrontend%2FLICENSE.TXT
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/weebik/