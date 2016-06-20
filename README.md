# NerdBoard

Mediates the usage of a common Scoreboard object amongst Nerd.nu plugins. A common API is exposed for adding and removing players and teams on the Scoreboard, with custom events that fire when an action is performed.

This is necessary because in newer versions of Spigot, the [ModMode](https://github.com/NerdNu/ModMode) plugin depends on Scoreboard to colorize name plates and manage collision settings.

## Development

Before compiling a depending plugin, you must install NerdBoard. Clone a copy of the repo and then use `mvn install` in the working directory to add it to your local Maven repo.

Next, you can add NerdBoard as a Maven dependency in your pom.xml:

```
<dependency>
    <groupId>nu.nerd</groupId>
    <artifactId>NerdBoard</artifactId>
    <version>1.0.0</version>
</dependency>
```
