package xml2json_v01; // присоединение класса к проекту

// импорт библиотек
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper; // библиотека Jackson
import java.text.DateFormat; // библиотека для форматирования объекта даты
import java.text.ParseException; // библиотека исключений чтения
import java.text.SimpleDateFormat; // библиотека для удобного форматирования дат
import java.util.ArrayList; // библиотека для возможности создания массива объектов
import java.util.Calendar; // календарь для того, чтобы можно было прибавлять днями без риска получить кривую дату
import java.util.Date; // библиотека объекта даты/времени
import java.util.GregorianCalendar; // еще одна библиотека григорианского календаря. Одна без другой плохо работает
import java.util.List; // библиотека для возможности создания списков
import java.util.logging.Level; // библиотека для удобства работы с логами. Тут логов нет, но без нее не работает что-то
import java.util.logging.Logger;// см. выше
import javax.xml.parsers.DocumentBuilder; // кучка библиотек для преобразования XML в JAVA - объект и работы с ним
import javax.xml.parsers.DocumentBuilderFactory;// вот
import javax.xml.parsers.ParserConfigurationException; // все
import org.w3c.dom.Document; //вот
import org.w3c.dom.Node; //эти
import org.xml.sax.SAXException; //вот

//основной класс программы
public class xml2json_v01 {

	public static void main(String[] args) { //throws IOException { // запуск основной функции
		
		System.out.println("Программа запустилась..."); //вывод сообщения в консоль
		
		String fileName = null; // объявление переменной имени файла
		
		for (int i = 0; i < args.length; i++) { //цикл для перебора аргументов программы (аргументы организованы в массив строк)
			switch (args[i]) { // переключатель (подразумевалось, что аргументов будет больше одного)
			case "-f": { // если найден аргумент -f, то...
				 fileName = args[i+1]; break; // ...имя исходного файла это значение следующего аргумента
				}
			default: break; // в любом другом случае - ничего не делать
			};
		};
		// проверяем, было ли указано имя файла
		if (fileName != null) { //если имя файла не пустое...
			System.out.println("Исходный файл: " + fileName); // ...то обрадовать пользователя сообщением в консоль
		}
		else { //... в противном случае ...
			System.out.println("Исходный файл не выбран!"); // ...гневный пост с предложением закрыть программу (без вариантов)
			System.out.println("Для выхода из программы нажмите Enter...");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ждет нажания клавиши ввода (парадокс в том, что это system("pause") тут нет, приходится извращаться)
			return; // выход из программы
		};
		
        System.out.print("Создание DOM..."); // вывод сообщения в консоль
		Document doc = null; // объявление объекта XML-документа
		try { // без обработчика ошибок отказывается работать
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // призывается строитель XML-объекта с помощью функций из библиотек
            // Создается дерево DOM документа из файла
            doc = documentBuilder.parse(fileName); // создается непосредственно XML-объект из файла, указанного при запуске программы
             // отлов кучи вариантов ошибок
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        };
        System.out.println("успешно."); // пока без косяков значит

        System.out.print("Извлечение нужных значений из XML..."); // начинаем извлекать из XML-объекта интересующие нас значения
        // извлечение дат
        String calculationDateRaw = doc.getElementsByTagName("DateOfCalc").item(0).getTextContent(); // ищем в объекте узел по имени тэга и извлекаем из него текстовое содержимое в строку
        DateFormat formatSrc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // объявляем формат даты в исходном файле (чтобы из строки корректно получить объект даты)
        DateFormat formatOut = new SimpleDateFormat("dd.MM.yyyy"); // объявляем целевой формат даты
        Date calculationDateAsDate = null; // объявляем объект даты и пока оставляем его пустым
		try {// тут опять без обработки исключений не хочет
			calculationDateAsDate = formatSrc.parse(calculationDateRaw); // переводим исходную строку, содержащую дату в объект даты согласно формата 
		} catch (ParseException e1) { // отлов специфического исключения которое может возникнуть при преобразовании строки в дату
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar();// теперь объявляем пустой объект календаря
		calendar.setTime(calculationDateAsDate); // устанавливаем ему время
        String calculationDate = formatOut.format(calculationDateAsDate);// генерируем строку, содержащую время в целевом формате навроде "01.01.2001"
        calendar.add(Calendar.DAY_OF_MONTH, 1); // с помощью метода календаря прибавляем к дате расчета 1 день - таким макаром получаем дату конца срока годности расчета
        String expirationDate = formatOut.format(calendar.getTime()); // и преобразуем эту дату в строку согласно целевого формата
        // извлечение сумм
        Node parentNode = doc.getElementsByTagName("AvailablePart").item(0).getChildNodes().item(3).getChildNodes().item(3).getChildNodes().item(9); // объявляем родительский узел XML-объекта (для сокращения кода), далее будем работать с его потомками
        Double availableAmount= Double.parseDouble(doc.getElementsByTagName("AvailableTotalSum").item(0).getTextContent()); // Извлекаем строковое значение доступной суммы и конвертируем его в двоичный тип (позволяет записывать числа с дробью)
        Double reservedAmount= Double.parseDouble(doc.getElementsByTagName("ReservedTotalSum").item(0).getTextContent());// см. выше дя зарезервированной суммы
        Double usedAmount= Double.parseDouble(doc.getElementsByTagName("UsedTotalSum").item(0).getTextContent());// см. выше для использованной суммы
        // извлечение списка доступных продуктов
        List<product> availableProducts = new ArrayList<product>(); // объявляем новый пустой список объектов класса product
        parentNode = doc.getElementsByTagName("AvailablePart").item(0).getChildNodes().item(3); // изменяем родительский узел. далее будем работать с его потомками
        for (int i = 3; i < parentNode.getChildNodes().getLength(); i = i+2) {// запускаем цикл заполнения списка доступных продуктов
            String id = parentNode.getChildNodes().item(i).getChildNodes().item(1).getChildNodes().item(3).getTextContent(); // создаем строковую переменную идентификатора и заполняем ее значением из XML-объекта
            String header = "Потребительский кредит"; // тут не понятно откуда брать этот параметр, так что для всех одно значение
            List<String> conditions = new ArrayList<String>(); // создаем новый пустой список строк conditions (условия)
            List<subProduct> subProducts = new ArrayList<subProduct>();// создаем новый пустой список объектов класса субпродукт
            Node parentNodeL2 = parentNode.getChildNodes().item(i).getChildNodes().item(9);// устанавливаем новый родительский узел XML второго уровня
            for (int j = 5; j < parentNodeL2.getChildNodes().getLength(); j = j+2) { // запуск цикла заполнения списка субродуктов обрабатываемого продукта
            	String subProductId = parentNode.getChildNodes().item(i).getChildNodes().item(1).getChildNodes().item(5).getTextContent();// извлекаем параметры из XML и рассовываем их по переменным
            	String currencyCode = "rub";// см. выше
            	Integer period = Integer.parseInt(parentNodeL2.getChildNodes().item(j).getChildNodes().item(3).getTextContent());// см. выше
            	Double rate = Double.parseDouble(parentNodeL2.getChildNodes().item(j).getChildNodes().item(5).getTextContent());// см. выше
            	Integer min = Integer.parseInt(parentNodeL2.getChildNodes().item(1).getTextContent())/100;// как вычислять минимум однозначно не понятно, потому что в XML нет узла с именем "минимум". Возможно, вычислено не правильно
            	Integer max = Integer.parseInt(parentNodeL2.getChildNodes().item(j).getChildNodes().item(7).getTextContent());// с максимумом все однозначно
//            	System.out.println("j = " + j + "/" + parentNodeL2.getChildNodes().getLength() + ": " + subProductId + " " + currencyCode + " " + period + " " + rate + " " + min + " " + max);
            	subProducts.add(new subProduct(subProductId, currencyCode, period, rate, min, max)); // добавляем в список субродуктов новый субпродукт с параметрами, которые извлекали выше
            }
            availableProducts.add(new product(id, header, conditions, subProducts)); // в список доступных продуктов добавляем новый продукт параметры которого вычислены на первом уровне цикла
        };       
        
        System.out.println("успешно."); // Фух
        
        System.out.print("Генерация JAVA-объекта..."); // Теперь собираем JAVA-объект, по структуре соответсвующий конечному файлу
        
        List<capacity_unit> capacityList = new ArrayList<capacity_unit>(); // новый пустой список capacity (емкость)
        capacityList.add(new capacity_unit("available", "Доступная часть", availableAmount)); // заполняем список объектами класса capacity_unit
        capacityList.add(new capacity_unit("reserved", "Зарезервированная часть", reservedAmount)); // см.выше
        capacityList.add(new capacity_unit("used", "Использованная часть", usedAmount)); // см. выше
        lendingCapacity lendingCapacity = new lendingCapacity(true, calculationDate, true, expirationDate, capacityList); // создаем новый объект lending capacity
        dashboard dashboard = new dashboard(); // создаем новый объект dashboard
        dashboard.setAvailableProducts(availableProducts); // засовываем в него список объектов доступных продуктов
        List<option> options = new ArrayList<option>(); // создаем новый список опций
        options.add(new option("LENDING_CAPACITY_LIFETIME", "1")); // заполняем его единственной известной опцией
        List<config> configs = new ArrayList<config>(); // создаем список конфигураций
        configs.add(new config("LENDING_CAPACITY_CONFIG", options));// добавляем в него новую конфигурацию с известными параметрами
        body body = new body(lendingCapacity, dashboard, configs); // создаем объект тела документа и упаковываем в него lendingCapacity, dashboard, configs
        List<message> messages = new ArrayList<message>(); // новый список объектов сообщений
        messages.add(new message("LC_MUST_BE_UPDATED|Срок действия расчета вашего кредитного потенциала истек", "Для обновления информации о том, какую сумму кредита и ежемесячный платеж вам одобрит банк, отправьте новый запрос. Информация предоставляется бесплатно.", "info"));
        GetClientRiskMetricsRs outputObject = new GetClientRiskMetricsRs(body, messages); // собираем корневой объект с упакованным в него телом и списком сообщений
        System.out.println("успешно."); // теперь все упаковано в один JAVA-объект
        
        System.out.print("Генерация JSON и запись в файл...");// теперь будем записывать все в JSON-файл
        
        generateJSON(outputObject);//вызываем функцию, которая описана ниже
        
        System.out.println("успешно.");//the End

	}
	
	private static void generateJSON(GetClientRiskMetricsRs obj) { // функция генерации JSON-файла из JAVA-объекта с помощью библиотеки Jackson
        ObjectMapper mapper = new ObjectMapper(); //создаем объект потроителя JSON-строки
        try {
            // Выводим в json файл
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream("output.json"), obj); // запись JSON-строки в файл с читабельным форматированием
            // Выводим на консоль (при желании)
//            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
        } catch (IOException ex) { // отлов специфических исключений
            Logger.getLogger(xml2json_v01.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }	

}
