#### 文档（Document）

-   Elasticsearch 是面向文档的，文档是所有可搜索数据的最小单位，可以对比为关系型数据库的一条记录。
-   文档会被序列化为 JSON 格式，保存在 Elasticsearch 中
-   每个文档都有一个 Unique ID



#### 文档的元数据

-   元数据，用于标注文档的相关信息
    -   _index : 文档所属的索引名
    -   _type : 文档所属的类型名
    -   _id : 文档唯一Id
    -   _source: 文档的原始 JSON 数据
    -   _all : 整合所有字段内容到该字段，已被废除
    -   _version : 文档的版本信息
    -   _score : 相关性打分



#### 索引

-   Index : 索引是文档的容器，是一类文档的结合
    -   Index 体现了逻辑空间的概念：每个索引都有自己的 Mapping 定义，用于定义包含的文档的字段名和字段类型。
    -   Shard 体现了物理空间的概念：索引中的数据分散在 Shard 上
-   索引的 Mapping 与 Settings
    -   Mapping 定义文档字段的类型
    -   Setting 定义不同的数据分布



#### 抽象与类比

| RDBMS  | Elasticsearch |
| :----: | :-----------: |
| Table  |     Index     |
|  Row   |   Document    |
| Column |     Filed     |
| Schema |    Mapping    |
|  SQL   |      DSL      |

-   传统关系型数据库和 Elasticsearch 的区别
    -   Elasticsearch : Schemaless / 相关性 / 高性能全文检索
    -   RDMS : 事务性 / join



#### 文档的 CRUD

| index  | PUT my_index/_doc/1<br>{"user":"lollipop", "comment":"You know, for search"} |
| :----: | :----------------------------------------------------------: |
| Create |                   PUT my_index/_create/1<br>{"user":"lollipop", "comment": "You know, for search"}<br>POST my_index/_doc(不指定ID, 自动生成)<br>{"user": "lollipop", "comment": "You know, for search"}                   |
| Read | GET my_index/_doc/1 |
| Update | POST my_index/_update/1<br>{"doc": {"user":"lollipop","comment": "You know, Elasticsearch"}} |
| Delete | DELETE my_index/_doc/1 |

-   Type 名，ES7约定都用 _doc
-   Create 如果ID存在，创建失败
-   Index 如果ID存在先删除现有文档，再创建新的文档，版本会增加
-   Update 文档必须已经存在，更新只会对相应字段做增量更新

#### Demo

``` json
// create document. 自动生成 _id
POST users/_doc
{
  "user": "lollipop",
  "post_date": "2020-12-21T21:40:22",
  "message": "trying out Kibana"
}

// create document. 指定Id，如果Id已经存在，则报错
PUT users/_doc/1?op_type=create
{
  "user": "lollipop1",
  "post_date": "2020-12-21T21:40:22",
  "message": "trying out Elasticsearch"
}

// create document. 指定Id，如果Id已经存在，则报错
PUT users/_create/1
{
  "user": "lollipop2",
  "post_date": "2020-12-21T21:40:22",
  "message": "trying out Elasticsearch"
}

// get document by Id
GET users/_doc/1


// index document. 指定Id，如果Id已经存在，则删除重建
PUT users/_doc/1
{
  "user": "lollipop3"
}

// update document. 在原文档上增加字段
POST users/_update/1
{
  "doc": {
    "post_date": "2020-12-21T21:40:22",
    "message": "trying out Elasticsearch"
  }
}

// delete document by Id. 删除文档
DELETE users/_doc/1

// Bulk 操作. 支持在一次 API 调用中，对不同的索引进行操作，单条操作失败，并不会影响其他操作，返回结果包括了每一条操作执行的结果.
POST _bulk
{"index": {"_index": "test", "_id": "1"}}
{"field1": "value1"}
{"delete": {"_index": "test", "_id": "2"}}
{"create": {"_index": "test2", "_id": "3"}}
{"field1": "value3"}
{"update": {"_id": "1", "_index": "test"}}
{"doc": {"field2": "value2"}}

// mget 操作，批量读取，减少网络开销
GET /_mget
{
  "docs": [
    {
      "_index": "test",
      "_id": "1"
    },
    {
      "_index": "test",
      "_id": "2"
    }
  ]
}
```



