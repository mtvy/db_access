# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: database.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0e\x64\x61tabase.proto\x12\x03\x61pi\"\x1a\n\x0cGetDbRequest\x12\n\n\x02tb\x18\x01 \x01(\t\"-\n\rGetDbResponse\x12\x0e\n\x06status\x18\x01 \x01(\r\x12\x0c\n\x04\x64\x61ta\x18\x02 \x01(\t\"=\n\x0fInsertDbRequest\x12\n\n\x02tb\x18\x01 \x01(\t\x12\x0e\n\x06\x63olums\x18\x02 \x03(\t\x12\x0e\n\x06values\x18\x03 \x03(\t\"\"\n\x10InsertDbResponse\x12\x0e\n\x06status\x18\x01 \x01(\r\",\n\x0f\x44\x65leteDbRequest\x12\n\n\x02tb\x18\x01 \x01(\t\x12\r\n\x05where\x18\x02 \x01(\t\"\"\n\x10\x44\x65leteDbResponse\x12\x0e\n\x06status\x18\x01 \x01(\r2\xb2\x01\n\x08\x44\x61tabase\x12\x30\n\x05GetDb\x12\x11.api.GetDbRequest\x1a\x12.api.GetDbResponse\"\x00\x12\x39\n\x08InsertDb\x12\x14.api.InsertDbRequest\x1a\x15.api.InsertDbResponse\"\x00\x12\x39\n\x08\x44\x65leteDb\x12\x14.api.DeleteDbRequest\x1a\x15.api.DeleteDbResponse\"\x00\x42\x07Z\x05./apib\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'database_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'Z\005./api'
  _GETDBREQUEST._serialized_start=23
  _GETDBREQUEST._serialized_end=49
  _GETDBRESPONSE._serialized_start=51
  _GETDBRESPONSE._serialized_end=96
  _INSERTDBREQUEST._serialized_start=98
  _INSERTDBREQUEST._serialized_end=159
  _INSERTDBRESPONSE._serialized_start=161
  _INSERTDBRESPONSE._serialized_end=195
  _DELETEDBREQUEST._serialized_start=197
  _DELETEDBREQUEST._serialized_end=241
  _DELETEDBRESPONSE._serialized_start=243
  _DELETEDBRESPONSE._serialized_end=277
  _DATABASE._serialized_start=280
  _DATABASE._serialized_end=458
# @@protoc_insertion_point(module_scope)
