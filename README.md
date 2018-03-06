# Spring Boot Flyway
## 特徴
||schema/data.sql|Flyway|
|:--|:-:|:-:|
|履歴|Git|V*__*.SQL|
|定義変更|変更後の状態を記述|変更スクリプトを記述|
|状態確認|schema/data.sql|migrateコマンド発行後のDB|
|物理変更|ユーザー|Flyway|

### schema/data.sql
- テーブル定義を確認しやすい。
### Flyway
- 物理変更をユーザーが行わなくてよい。
- テーブル定義変更スクリプトがテスト済である。

## データベース、環境に合わせたFlywayの使い分け
||app|test|
|:--|:-:|:-:|
|prod|MariaDB|x|
|dev|MariaDB|x|
|default|H2(In memory)|H2(In memory)|

### Maria DB
- セットアップ後にデータの操作は行わない。
### H2(In memory)
- テストデータを都度挿入する。

### DDL

||app|test|
|:--|:-:|:-:|
|prod|Flyway|x|
|dev|Flyway|x|
|default|Flyway|Flyway|

### DML(マスターデータ)

||app|test|
|:--|:-:|:-:|
|prod|Flyway|x|
|dev|Flyway|x|
|default|Flyway|Flyway|

### DML(テストデータ)

||app|test|
|:--|:-:|:-:|
|prod|x|x|
|dev|手動|x|
|default|Flyway(+ dataset)|Flyway(+ dataset)|

- データセット指定オプション
  - default: flyway.locations=classpath:/db/migration, classpath:/db/dataset
  - dev: flyway.locations=classpath:/db/migration
  - prod: flyway.locations=classpath:/db/migration
