# ebot-events

Application to receive all CS:go server statistics and store them to files(for later use). Supports multiple servers

## Usage

### Configurations
Change UDP port and event log file path at the config file directory.

### Run the application locally

`lein with-profile prod do clean, ring uberjar`

### Packaging and running as standalone jar for production

```
lein do clean, ring uberjar
java -jar target/server.jar
```


## License

Copyright ©  Yleisradio

The MIT License (MIT)
