## Testing Requests
- Exapmle of simple Requests
    ```bash
    go test -run=. 
    ```
- Example of plain run
    ```bash
    GOGC=off go test -bench=BenchmarkPlainRun -cpuprofile plain_run_cpu.out
    ```
- Example of goroutins run
    ```bash
    GOGC=off go test -bench=BenchmarkRoutins -cpuprofile goroutins_cpu.out
    ```
- Get pprof tree
    ```bash
    go tool pprof --edgefraction=0 --nodefraction=0 --nodecount=100000 database_test.test cpu.out
    ```
    ```pprof
    (pprof) web
    ```
