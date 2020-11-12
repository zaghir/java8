package com.zaghir.projet.transformation.java2json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class JavaToSchemaJson {

	public static void main(String[] args) {



		try {

//			Class<?> c = Class.forName("ats.ods.GGaiaV2Canton");
//			Object o = c.newInstance();
//			methode2(o.getClass());
			
			Class<?> c = null ;
			
			List<String> classesName = Arrays.asList(
					"com.zaghir.projet.notionjava.bean.Apple",
					"com.zaghir.projet.notionjava.bean.Banana");
			List<Object> classes = new ArrayList<Object>();
			
			for(String s : classesName) {
				c = Class.forName(s);
				Object o = c.newInstance();
				classes.add(o);
			}
			methode3(classes);
//			c = Class.forName("ats.ods.GGaiaV2Canton");
//			Object o = c.newInstance();
//			methode2(o.getClass());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getSchema(Class classs) {
		String schemaClass = null;
		ObjectMapper mapper = new ObjectMapper();
		SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
		try {
//        	mapper.acceptJsonFormatVisitor(classs.class, visitor);
			mapper.acceptJsonFormatVisitor(classs.getClass(), visitor);
			JsonSchema schema = visitor.finalSchema();
			schemaClass = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema));

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schemaClass;
	}

	public static void methode2(Class<?> classs) throws JsonGenerationException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);

		JsonSchema jsonSchema = generator.generateSchema(classs);
//    JsonSchema jsonSchema = generator.generateSchema(classs.class);

		StringWriter jsonString = new StringWriter();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		jsonSchema.setId(classs.getSimpleName());
		mapper.writeValue(jsonString, jsonSchema);
//    mapper.enableDefaultTyping();
//    PolymorphicTypeValidator ptv = PolymorphicTypeValidator();
//    mapper.activateDefaultTyping(DefaultTyping.NON_FINAL ,PolymorphicTypeValidator.Validity.ALLOWED);
// 

//    JsonNode root = mapper.readTree(jsonString.toString());
//
//    for (JsonNode jsonNode : root) {
//        if (jsonNode instanceof ObjectNode) {
//            ObjectNode o = (ObjectNode) jsonNode;
//            o.remove("type");            
//        }
//    }
		
		

		System.out.println(jsonString.toString());
	}
	
	
	public static void methode3(List<Object> classss) throws JsonGenerationException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
		JsonSchema jsonSchema = null ;

		StringWriter jsonString = new StringWriter();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		List<String> str = new ArrayList<>();
		
		 
		for(Object c : classss) {
			StringWriter ss = new StringWriter();
			ss.getBuffer().trimToSize();
			jsonSchema = generator.generateSchema(c.getClass());
			jsonSchema.setId(c.getClass().getSimpleName());
//			mapper.writeValue(jsonString, jsonSchema);
			mapper.writeValue(ss, jsonSchema);			
			str.add(ss.toString()) ;
			System.out.println(ss);
			
		}
		
		mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonString);
		
		FileOutputStream fos = new FileOutputStream("json-structure-table-stockage-brut.json");
		OutputStreamWriter outputFile = new OutputStreamWriter(fos, StandardCharsets.UTF_8) ;
	    outputFile.write(str.toString());
	    outputFile.close();
		
		System.out.println(jsonString.toString());
	}

}
