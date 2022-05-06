<div align="center">

# Topology API

</div>

<div align="center">

[![contributors](https://img.shields.io/github/contributors/Abd-ELrahmanHamza/Topology_API)](https://github.com/Abd-ELrahmanHamza/Topology_API/contributors)
[![license](https://img.shields.io/pypi/l/ansicolortags.svg)](LICENSE)
[![forks](https://img.shields.io/github/forks/Abd-ELrahmanHamza/Topology_API)](https://github.com/Abd-ELrahmanHamza/Topology_API/network)
[![stars](https://img.shields.io/github/stars/Abd-ELrahmanHamza/Topology_API)](https://github.com/Abd-ELrahmanHamza/Topology_API/stargazers)
[![issues](https://img.shields.io/github/issues/Abd-ELrahmanHamza/Topology_API)](https://github.com/Abd-ELrahmanHamza/Topology_API/issues)

</div>

Provide the functionality to access, manage and store device topologies.

## Description
1. Read a topology from a given JSON file and store it in the memory.
2. Write a given topology from the memory to a JSON file.
3. Query about which topologies are currently in the memory.
4. Delete a given topology from memory.
5. Query about which devices are in a given topology.
6. Query about which devices are connected to a given netlist node in
   a given topology.

## Getting Started

### Classes
#### MainClass

* This class contains the main function you need to run the API
* It creates an object from Topologies and call its functions

#### Topologies

Consists of Topologies

* This class contains the functions of the API :-
  * void readJSON(String fileName)
  * void writeJSON(String topologyID)
  * Set<String> getTopologies()
  * boolean deleteTopology(String topologyID)
  * List<Component> queryDevices(String topologyID)
  * List<Component> queryDevicesWithNetlistNode(String topologyID, String node)

#### Topology

Each topology consists of components and the JSON format of the topology

#### Component

Each component contains the ID and type of the component (Maybe extended if required)

#### Testing

This class tests each function of class Topologies

### Dependencies

* Java
* json.simple

### Installing

```
git clone https://github.com/Abd-ELrahmanHamza/Topology_API 
```

### Screenshots

#### Read JSON file
![start](screenshots/1.png)

#### Query Topologies
![start](screenshots/2.png)

#### Read JSON file & Query Topologies
![start](screenshots/3.png)
![start](screenshots/4.png)

#### Output File
![start](screenshots/5.png)

#### Delete a topology & Query Topologies
![start](screenshots/6.png)

#### Query devices in a topology
![start](screenshots/7.png)

#### Query devices with netlist node then exit
![start](screenshots/8.png)

#### Testing
![start](screenshots/9.png)

## Contributors

<table>
<tr>
<td align="center">
<a href="https://github.com/Abd-ELrahmanHamza" target="_black">
<img src="https://avatars.githubusercontent.com/u/68310502?v=4" width="150px;" alt="Abdelrahman Hamza"/><br /><sub><b>Abdelrahman Hamza</b></sub></a><br />
</td>
</tr>
 </table>

## License

This project is licensed under the [MIT] License - see the [LICENSE.md](LICENSE) file for details
