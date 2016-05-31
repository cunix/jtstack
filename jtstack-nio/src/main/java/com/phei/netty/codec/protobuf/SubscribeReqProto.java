package com.phei.netty.codec.protobuf;

import java.io.ObjectStreamException;
import java.util.List;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnmodifiableLazyStringList;

public final class SubscribeReqProto {
	
	private SubscribeReqProto() {

	}

	public static void registerAllExtensions(ExtensionRegistry registry) {

	}

	public interface SubscribeReqOrBuilder extends MessageOrBuilder {

		boolean hasSubReqID();

		int getSubReqID();

		boolean hasUserName();

		String getUserName();

		ByteString getUserNameBytes();

		boolean hasProductName();

		String getProductName();

		ByteString getProductNameBytes();

		List<String> getAddressList();

		int getAddressCount();

		String getAddress(int index);

		ByteString getAddressBytes(int index);
	}


	public static final class SubscribeReq extends GeneratedMessage implements SubscribeReqOrBuilder {
		// Use SubscribeReq.newBuilder() to construct.
		private SubscribeReq(GeneratedMessage.Builder<?> builder) {
			super(builder);
			this.unknownFields = builder.getUnknownFields();
		}

		private SubscribeReq(boolean noInit) {
			this.unknownFields = UnknownFieldSet.getDefaultInstance();
		}

		private static final SubscribeReq defaultInstance;

		public static SubscribeReq getDefaultInstance() {
			return defaultInstance;
		}

		public SubscribeReq getDefaultInstanceForType() {
			return defaultInstance;
		}

		private final UnknownFieldSet unknownFields;

		@Override
		public final UnknownFieldSet getUnknownFields() {
			return this.unknownFields;
		}

		private SubscribeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
				throws InvalidProtocolBufferException {
			initFields();
			int mutable_bitField0_ = 0;
			UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
			try {
				boolean done = false;
				while (!done) {
					int tag = input.readTag();
					switch (tag) {
					case 0:
						done = true;
						break;
					default: {
						if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
							done = true;
						}
						break;
					}
					case 8: {
						bitField0_ |= 0x00000001;
						subReqID_ = input.readInt32();
						break;
					}
					case 18: {
						bitField0_ |= 0x00000002;
						userName_ = input.readBytes();
						break;
					}
					case 26: {
						bitField0_ |= 0x00000004;
						productName_ = input.readBytes();
						break;
					}
					case 34: {
						if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
							address_ = new LazyStringArrayList();
							mutable_bitField0_ |= 0x00000008;
						}
						address_.add(input.readBytes());
						break;
					}
					}
				}
			} catch (InvalidProtocolBufferException e) {
				throw e.setUnfinishedMessage(this);
			} catch (java.io.IOException e) {
				throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
			} finally {
				if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
					address_ = new UnmodifiableLazyStringList(address_);
				}
				this.unknownFields = unknownFields.build();
				makeExtensionsImmutable();
			}
		}

		public static final Descriptors.Descriptor getDescriptor() {
			return SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
		}

		protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
			return SubscribeReqProto.internal_static_netty_SubscribeReq_fieldAccessorTable
					.ensureFieldAccessorsInitialized(SubscribeReqProto.SubscribeReq.class,
							SubscribeReqProto.SubscribeReq.Builder.class);
		}

		public static Parser<SubscribeReq> PARSER = new AbstractParser<SubscribeReq>() {
			public SubscribeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
					throws InvalidProtocolBufferException {
				return new SubscribeReq(input, extensionRegistry);
			}
		};

		@Override
		public Parser<SubscribeReq> getParserForType() {
			return PARSER;
		}

		private int bitField0_;

		public static final int SUBREQID_FIELD_NUMBER = 1;
		private int subReqID_;

		public boolean hasSubReqID() {
			return ((bitField0_ & 0x00000001) == 0x00000001);
		}

		public int getSubReqID() {
			return subReqID_;
		}

		public static final int USERNAME_FIELD_NUMBER = 2;
		private Object userName_;

		public boolean hasUserName() {
			return ((bitField0_ & 0x00000002) == 0x00000002);
		}

		public String getUserName() {
			Object ref = userName_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					userName_ = s;
				}
				return s;
			}
		}

		public ByteString getUserNameBytes() {
			Object ref = userName_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				userName_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		public static final int PRODUCTNAME_FIELD_NUMBER = 3;
		private Object productName_;

		public boolean hasProductName() {
			return ((bitField0_ & 0x00000004) == 0x00000004);
		}

		public String getProductName() {
			Object ref = productName_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					productName_ = s;
				}
				return s;
			}
		}

		public ByteString getProductNameBytes() {
			Object ref = productName_;
			if (ref instanceof String) {
				com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((String) ref);
				productName_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		
		public static final int ADDRESS_FIELD_NUMBER = 4;
		private com.google.protobuf.LazyStringList address_;

		public java.util.List<String> getAddressList() {
			return address_;
		}

		public int getAddressCount() {
			return address_.size();
		}

		/**
		 * <code>repeated string address = 4;</code>
		 */
		public String getAddress(int index) {
			return address_.get(index);
		}

		/**
		 * <code>repeated string address = 4;</code>
		 */
		public com.google.protobuf.ByteString getAddressBytes(int index) {
			return address_.getByteString(index);
		}

		private void initFields() {
			subReqID_ = 0;
			userName_ = "";
			productName_ = "";
			address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		}

		private byte memoizedIsInitialized = -1;

		public final boolean isInitialized() {
			byte isInitialized = memoizedIsInitialized;
			if (isInitialized != -1)
				return isInitialized == 1;

			if (!hasSubReqID()) {
				memoizedIsInitialized = 0;
				return false;
			}
			if (!hasUserName()) {
				memoizedIsInitialized = 0;
				return false;
			}
			if (!hasProductName()) {
				memoizedIsInitialized = 0;
				return false;
			}
			memoizedIsInitialized = 1;
			return true;
		}

		public void writeTo(CodedOutputStream output) throws java.io.IOException {
			getSerializedSize();
			if (((bitField0_ & 0x00000001) == 0x00000001)) {
				output.writeInt32(1, subReqID_);
			}
			if (((bitField0_ & 0x00000002) == 0x00000002)) {
				output.writeBytes(2, getUserNameBytes());
			}
			if (((bitField0_ & 0x00000004) == 0x00000004)) {
				output.writeBytes(3, getProductNameBytes());
			}
			for (int i = 0; i < address_.size(); i++) {
				output.writeBytes(4, address_.getByteString(i));
			}
			getUnknownFields().writeTo(output);
		}

		private int memoizedSerializedSize = -1;

		public int getSerializedSize() {
			int size = memoizedSerializedSize;
			if (size != -1)
				return size;
			size = 0;
			if (((bitField0_ & 0x00000001) == 0x00000001)) {
				size += com.google.protobuf.CodedOutputStream.computeInt32Size(1, subReqID_);
			}
			if (((bitField0_ & 0x00000002) == 0x00000002)) {
				size += com.google.protobuf.CodedOutputStream.computeBytesSize(2, getUserNameBytes());
			}
			if (((bitField0_ & 0x00000004) == 0x00000004)) {
				size += com.google.protobuf.CodedOutputStream.computeBytesSize(3, getProductNameBytes());
			}
			{
				int dataSize = 0;
				for (int i = 0; i < address_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag(address_.getByteString(i));
				}
				size += dataSize;
				size += 1 * getAddressList().size();
			}
			size += getUnknownFields().getSerializedSize();
			memoizedSerializedSize = size;
			return size;
		}

		private static final long serialVersionUID = 0L;

		@Override
		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(com.google.protobuf.ByteString data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(java.io.InputStream input) throws java.io.IOException {
			return PARSER.parseFrom(input);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(java.io.InputStream input,
				ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return PARSER.parseFrom(input, extensionRegistry);
		}

		public static SubscribeReqProto.SubscribeReq parseDelimitedFrom(java.io.InputStream input)
				throws java.io.IOException {
			return PARSER.parseDelimitedFrom(input);
		}

		public static SubscribeReqProto.SubscribeReq parseDelimitedFrom(java.io.InputStream input,
				ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(CodedInputStream input) throws java.io.IOException {
			return PARSER.parseFrom(input);
		}

		public static SubscribeReqProto.SubscribeReq parseFrom(CodedInputStream input,
				ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return PARSER.parseFrom(input, extensionRegistry);
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public static Builder newBuilder(SubscribeReqProto.SubscribeReq prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		@Override
		protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
			Builder builder = new Builder(parent);
			return builder;
		}

		/**
		 * Protobuf type {@code netty.SubscribeReq}
		 */
		public static final class Builder extends GeneratedMessage.Builder<Builder>
				implements SubscribeReqProto.SubscribeReqOrBuilder {
			public static final Descriptors.Descriptor getDescriptor() {
				return SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
			}

			protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
				return SubscribeReqProto.internal_static_netty_SubscribeReq_fieldAccessorTable
						.ensureFieldAccessorsInitialized(SubscribeReqProto.SubscribeReq.class,
								SubscribeReqProto.SubscribeReq.Builder.class);
			}

			// Construct using
			// SubscribeReqProto.SubscribeReq.newBuilder()
			private Builder() {
				maybeForceBuilderInitialization();
			}

			private Builder(GeneratedMessage.BuilderParent parent) {
				super(parent);
				maybeForceBuilderInitialization();
			}

			private void maybeForceBuilderInitialization() {
				if (GeneratedMessage.alwaysUseFieldBuilders) {
				}
			}

			private static Builder create() {
				return new Builder();
			}

			public Builder clear() {
				super.clear();
				subReqID_ = 0;
				bitField0_ = (bitField0_ & ~0x00000001);
				userName_ = "";
				bitField0_ = (bitField0_ & ~0x00000002);
				productName_ = "";
				bitField0_ = (bitField0_ & ~0x00000004);
				address_ = LazyStringArrayList.EMPTY;
				bitField0_ = (bitField0_ & ~0x00000008);
				return this;
			}

			public Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Descriptors.Descriptor getDescriptorForType() {
				return SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
			}

			public SubscribeReqProto.SubscribeReq getDefaultInstanceForType() {
				return SubscribeReqProto.SubscribeReq.getDefaultInstance();
			}

			public SubscribeReqProto.SubscribeReq build() {
				SubscribeReqProto.SubscribeReq result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public SubscribeReqProto.SubscribeReq buildPartial() {
				SubscribeReqProto.SubscribeReq result = new SubscribeReqProto.SubscribeReq(this);
				int from_bitField0_ = bitField0_;
				int to_bitField0_ = 0;
				if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
					to_bitField0_ |= 0x00000001;
				}
				result.subReqID_ = subReqID_;
				if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
					to_bitField0_ |= 0x00000002;
				}
				result.userName_ = userName_;
				if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
					to_bitField0_ |= 0x00000004;
				}
				result.productName_ = productName_;
				if (((bitField0_ & 0x00000008) == 0x00000008)) {
					address_ = new UnmodifiableLazyStringList(address_);
					bitField0_ = (bitField0_ & ~0x00000008);
				}
				result.address_ = address_;
				result.bitField0_ = to_bitField0_;
				onBuilt();
				return result;
			}

			public Builder mergeFrom(com.google.protobuf.Message other) {
				if (other instanceof SubscribeReqProto.SubscribeReq) {
					return mergeFrom((SubscribeReqProto.SubscribeReq) other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(SubscribeReqProto.SubscribeReq other) {
				if (other == SubscribeReqProto.SubscribeReq.getDefaultInstance())
					return this;
				if (other.hasSubReqID()) {
					setSubReqID(other.getSubReqID());
				}
				if (other.hasUserName()) {
					bitField0_ |= 0x00000002;
					userName_ = other.userName_;
					onChanged();
				}
				if (other.hasProductName()) {
					bitField0_ |= 0x00000004;
					productName_ = other.productName_;
					onChanged();
				}
				if (!other.address_.isEmpty()) {
					if (address_.isEmpty()) {
						address_ = other.address_;
						bitField0_ = (bitField0_ & ~0x00000008);
					} else {
						ensureAddressIsMutable();
						address_.addAll(other.address_);
					}
					onChanged();
				}
				this.mergeUnknownFields(other.getUnknownFields());
				return this;
			}

			public final boolean isInitialized() {
				if (!hasSubReqID()) {

					return false;
				}
				if (!hasUserName()) {

					return false;
				}
				if (!hasProductName()) {

					return false;
				}
				return true;
			}

			public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				SubscribeReqProto.SubscribeReq parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (InvalidProtocolBufferException e) {
					parsedMessage = (SubscribeReqProto.SubscribeReq) e.getUnfinishedMessage();
					throw e;
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}

			private int bitField0_;

			// required int32 subReqID = 1;
			private int subReqID_;

			/**
			 * <code>required int32 subReqID = 1;</code>
			 */
			public boolean hasSubReqID() {
				return ((bitField0_ & 0x00000001) == 0x00000001);
			}

			public int getSubReqID() {
				return subReqID_;
			}

			public Builder setSubReqID(int value) {
				bitField0_ |= 0x00000001;
				subReqID_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>required int32 subReqID = 1;</code>
			 */
			public Builder clearSubReqID() {
				bitField0_ = (bitField0_ & ~0x00000001);
				subReqID_ = 0;
				onChanged();
				return this;
			}

			// required string userName = 2;
			private Object userName_ = "";

			/**
			 * <code>required string userName = 2;</code>
			 */
			public boolean hasUserName() {
				return ((bitField0_ & 0x00000002) == 0x00000002);
			}

			/**
			 * <code>required string userName = 2;</code>
			 */
			public String getUserName() {
				Object ref = userName_;
				if (!(ref instanceof String)) {
					String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
					userName_ = s;
					return s;
				} else {
					return (String) ref;
				}
			}

			/**
			 * <code>required string userName = 2;</code>
			 */
			public com.google.protobuf.ByteString getUserNameBytes() {
				Object ref = userName_;
				if (ref instanceof String) {
					com.google.protobuf.ByteString b = com.google.protobuf.ByteString
							.copyFromUtf8((String) ref);
					userName_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			/**
			 * <code>required string userName = 2;</code>
			 */
			public Builder setUserName(String value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000002;
				userName_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>required string userName = 2;</code>
			 */
			public Builder clearUserName() {
				bitField0_ = (bitField0_ & ~0x00000002);
				userName_ = getDefaultInstance().getUserName();
				onChanged();
				return this;
			}

			/**
			 * <code>required string userName = 2;</code>
			 */
			public Builder setUserNameBytes(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000002;
				userName_ = value;
				onChanged();
				return this;
			}

			// required string productName = 3;
			private Object productName_ = "";

			/**
			 * <code>required string productName = 3;</code>
			 */
			public boolean hasProductName() {
				return ((bitField0_ & 0x00000004) == 0x00000004);
			}

			/**
			 * <code>required string productName = 3;</code>
			 */
			public String getProductName() {
				Object ref = productName_;
				if (!(ref instanceof String)) {
					String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
					productName_ = s;
					return s;
				} else {
					return (String) ref;
				}
			}

			/**
			 * <code>required string productName = 3;</code>
			 */
			public com.google.protobuf.ByteString getProductNameBytes() {
				Object ref = productName_;
				if (ref instanceof String) {
					com.google.protobuf.ByteString b = com.google.protobuf.ByteString
							.copyFromUtf8((String) ref);
					productName_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			/**
			 * <code>required string productName = 3;</code>
			 */
			public Builder setProductName(String value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000004;
				productName_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>required string productName = 3;</code>
			 */
			public Builder clearProductName() {
				bitField0_ = (bitField0_ & ~0x00000004);
				productName_ = getDefaultInstance().getProductName();
				onChanged();
				return this;
			}

			/**
			 * <code>required string productName = 3;</code>
			 */
			public Builder setProductNameBytes(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000004;
				productName_ = value;
				onChanged();
				return this;
			}

			// repeated string address = 4;
			private com.google.protobuf.LazyStringList address_ = com.google.protobuf.LazyStringArrayList.EMPTY;

			private void ensureAddressIsMutable() {
				if (!((bitField0_ & 0x00000008) == 0x00000008)) {
					address_ = new com.google.protobuf.LazyStringArrayList(address_);
					bitField0_ |= 0x00000008;
				}
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public java.util.List<String> getAddressList() {
				return java.util.Collections.unmodifiableList(address_);
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public int getAddressCount() {
				return address_.size();
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public String getAddress(int index) {
				return address_.get(index);
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public com.google.protobuf.ByteString getAddressBytes(int index) {
				return address_.getByteString(index);
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public Builder setAddress(int index, String value) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureAddressIsMutable();
				address_.set(index, value);
				onChanged();
				return this;
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public Builder addAddress(String value) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureAddressIsMutable();
				address_.add(value);
				onChanged();
				return this;
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public Builder addAllAddress(Iterable<String> values) {
				ensureAddressIsMutable();
				super.addAll(values, address_);
				onChanged();
				return this;
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public Builder clearAddress() {
				address_ = com.google.protobuf.LazyStringArrayList.EMPTY;
				bitField0_ = (bitField0_ & ~0x00000008);
				onChanged();
				return this;
			}

			/**
			 * <code>repeated string address = 4;</code>
			 */
			public Builder addAddressBytes(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureAddressIsMutable();
				address_.add(value);
				onChanged();
				return this;
			}

			// @@protoc_insertion_point(builder_scope:netty.SubscribeReq)
		}

		static {
			defaultInstance = new SubscribeReq(true);
			defaultInstance.initFields();
		}

		// @@protoc_insertion_point(class_scope:netty.SubscribeReq)
	}

	private static Descriptors.Descriptor internal_static_netty_SubscribeReq_descriptor;
	private static GeneratedMessage.FieldAccessorTable internal_static_netty_SubscribeReq_fieldAccessorTable;

	public static Descriptors.FileDescriptor getDescriptor() {
		return descriptor;
	}

	private static Descriptors.FileDescriptor descriptor;
	static {
		String[] descriptorData = { "\n\030netty/SubscribeReq.proto\022\005netty\"X\n\014Sub"
				+ "scribeReq\022\020\n\010subReqID\030\001 \002(\005\022\020\n\010userName\030"
				+ "\002 \002(\t\022\023\n\013productName\030\003 \002(\t\022\017\n\007address\030\004 "
				+ "\003(\tB2\n\035com.phei.netty.codec.protobufB\021Su" + "bscribeReqProto" };
		Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
			public ExtensionRegistry assignDescriptors(
					Descriptors.FileDescriptor root) {
				descriptor = root;
				internal_static_netty_SubscribeReq_descriptor = getDescriptor().getMessageTypes().get(0);
				internal_static_netty_SubscribeReq_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
						internal_static_netty_SubscribeReq_descriptor,
						new String[] { "SubReqID", "UserName", "ProductName", "Address", });
				return null;
			}
		};
		Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
				new Descriptors.FileDescriptor[] {}, assigner);
	}


}
