Tool for distance comparison for [OSRM](http://project-osrm.org) and [Google Direction API](https://developers.google.com/maps/documentation/directions/).

```
-r report.csv - path to output report
-d details.csv - path to report details
-c config.yml - path to config in YAMAL format
-b bounds.yml - path to bounds in YAML format
```

*-c config.yml*
```
osrm:
  host: http://router.project-osrm.org
google:
  departure_time: now
  traffic_model: optimistic|best_guess|pessimistic
  alternatives: true|false
```

*-b bounds.yml*
```
areas:
  - name: HCMC
    bounds:
      - [-6.088070, 106.694235]
      - [-6.256005, 106.9565331]
    iterations: 5
```

---
Report example

|           |      |
|-----------|------|
| Processor | Wins |
| Google    | 1    |
| OSRM      | 4    |

Details example

|      |                 |                   |            |       |
|------|-----------------|-------------------|------------|-------|
| Name | Processor       | Processor         | Difference | Debug |
| HCMC | OSRM - 9602.3m  | Google - 9688.0m  | -86m       |       |
| HCMC | OSRM - 12276.3m | Google - 12811.0m | -535m      |       |
| HCMC | OSRM - 17562.6m | Google - 23011.0m | -5448m     |       |
| HCMC | OSRM - 19631.5m | Google - 17456.0m | 2176m      |       |
| HCMC | OSRM - 39497.4m | Google - 39902.0m | -405m      |       |