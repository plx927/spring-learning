package com.panlingxiao.spring.learning.webmvc.httpconverter;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by panlingxiao on 2016/7/6.
 */
public class Jaxb2RootElementHttpMessageConverterTest {



    @Test
    public void testJaxb() throws JAXBException {
        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Person person = new Person();
        person.setAge(20);
        person.setName("hello world");
        person.setBirth(new Date());
        // Writing to console
        jaxbMarshaller.marshal(person, System.out);
    }


    //Below annotation defines root element of XML file
    @XmlRootElement
    //You can define order in which elements will be created in XML file
    //Optional
    @XmlType(propOrder = { "countryName", "countryPopulation", "listOfStates"})
    public  static class Country{
        private String countryName;
        private double countryPopulation;
        private ArrayList<State> listOfStates;
        public Country() {

        }
        public String getCountryName() {
            return countryName;
        }
        @XmlElement
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }
        public double getCountryPopulation() {
            return countryPopulation;
        }

        @XmlElement
        public void setCountryPopulation(double countryPopulation) {
            this.countryPopulation = countryPopulation;
        }

        public ArrayList<State> getListOfStates() {
            return listOfStates;
        }

        // XmLElementWrapper generates a wrapper element around XML representation
        @XmlElementWrapper(name = "stateList")
        // XmlElement sets the name of the entities in collection
        @XmlElement(name = "state")
        public void setListOfStates(ArrayList<State> listOfStates) {
            this.listOfStates = listOfStates;
        }
    }


    //Below statement means that class 'Country.java' is the root-element of our example
    @XmlRootElement(namespace ="org.arpit.javapostsforlearning.jaxb.Country")
    static class State {
        private String stateName;
        long statePopulation;

        public State()
        {

        }
        public State(String stateName, long statePopulation) {
            super();
            this.stateName = stateName;
            this.statePopulation = statePopulation;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public long getStatePopulation() {
            return statePopulation;
        }

        public void setStatePopulation(long statePopulation) {
            this.statePopulation = statePopulation;
        }
    }

    @Test
     public void testJAXBJavaToXml(){
        // creating country object
        Country countryIndia=new Country();
        countryIndia.setCountryName("India");
        countryIndia.setCountryPopulation(5000000);

        // Creating listOfStates
        ArrayList<State> stateList=new ArrayList<State>();
        State mpState=new State("Madhya Pradesh",1000000);
        State maharastraState=new State("Maharastra",2000000);
        stateList.add(mpState);
        stateList.add(maharastraState);
        countryIndia.setListOfStates(stateList);
        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // for getting nice formatted output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Writing to console
            jaxbMarshaller.marshal(countryIndia, System.out);

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }
    }



}
