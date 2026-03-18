## ISO/IEC 25010 & 25023 Reference Table

| ISO 25010 Characteristic | ISO Code | ISO 25023 Metric | Direction | Unit | Formula Summary |
|--------------------------|----------|------------------|-----------|------|-----------------|
| Functional Suitability   | QC.FS    | Functional Completeness Ratio | Higher | % | Implemented functions / Planned functions × 100 |
| Functional Suitability   | QC.FS    | Functional Correctness Ratio  | Higher | % | Correct-output tests / Total tests × 100 |
| Reliability              | QC.RE    | Availability Ratio            | Higher | % | Uptime / (Uptime + Downtime) × 100 |
| Reliability              | QC.RE    | Defect Density                | Lower  | defect/KLOC | Defects found / 1000 LOC |
| Performance Efficiency   | QC.PE    | Response Time                 | Lower  | ms | Average response time |
| Performance Efficiency   | QC.PE    | CPU Utilisation Ratio         | Lower  | % | CPU used / Total CPU × 100 |
| Maintainability          | QC.MA    | Test Coverage Ratio           | Higher | % | Tested LOC / Total LOC × 100 |
| Maintainability          | QC.MA    | Cyclomatic Complexity (avg)   | Lower  | score | Average complexity per module |