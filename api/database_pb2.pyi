from google.protobuf.internal import containers as _containers
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Iterable as _Iterable, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class DeleteDbRequest(_message.Message):
    __slots__ = ["tb", "where"]
    TB_FIELD_NUMBER: _ClassVar[int]
    WHERE_FIELD_NUMBER: _ClassVar[int]
    tb: str
    where: str
    def __init__(self, tb: _Optional[str] = ..., where: _Optional[str] = ...) -> None: ...

class DeleteDbResponse(_message.Message):
    __slots__ = ["status"]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    status: int
    def __init__(self, status: _Optional[int] = ...) -> None: ...

class GetDbRequest(_message.Message):
    __slots__ = ["tb"]
    TB_FIELD_NUMBER: _ClassVar[int]
    tb: str
    def __init__(self, tb: _Optional[str] = ...) -> None: ...

class GetDbResponse(_message.Message):
    __slots__ = ["data", "status"]
    DATA_FIELD_NUMBER: _ClassVar[int]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    data: str
    status: int
    def __init__(self, status: _Optional[int] = ..., data: _Optional[str] = ...) -> None: ...

class InsertDbRequest(_message.Message):
    __slots__ = ["colums", "tb", "values"]
    COLUMS_FIELD_NUMBER: _ClassVar[int]
    TB_FIELD_NUMBER: _ClassVar[int]
    VALUES_FIELD_NUMBER: _ClassVar[int]
    colums: _containers.RepeatedScalarFieldContainer[str]
    tb: str
    values: _containers.RepeatedScalarFieldContainer[str]
    def __init__(self, tb: _Optional[str] = ..., colums: _Optional[_Iterable[str]] = ..., values: _Optional[_Iterable[str]] = ...) -> None: ...

class InsertDbResponse(_message.Message):
    __slots__ = ["status"]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    status: int
    def __init__(self, status: _Optional[int] = ...) -> None: ...
