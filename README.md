||schema.sql, data.sql|Flyway|
|:--|:-:|:-:|
|履歴|Git|V*__*.SQL|
|定義変更|変更後の状態を記述|変更スクリプトを記述|
|状態確認|schema.sql, data.sql|migrateコマンド発行後のDB|
|物理変更|ユーザー|Flyway|

- H2
  - テーブル定義を確認しやすい。
- Flyway
  - テーブル定義の変更をユーザーが行わなくてよい。

||app|test|
|:--|:-:|:-:|
|prod|MariaDB|x|
|dev|MariaDB|x|
|local|H2(In memory)|H2(In memory)|

- Maria DB
  - Flywayでデータの変更を保持したまま作業する。
- H2(In memory)
  - schema.sql, data.sqlを使う場合と同様にFlywayで作業可能。
