package rzh.smartsducationsystem.service.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rzh.smartsducationsystem.bean.BeanFactory;
import rzh.smartsducationsystem.dao.OptionDao;
import rzh.smartsducationsystem.dao.TopicDao;
import rzh.smartsducationsystem.dao.WorkDao;
import rzh.smartsducationsystem.model.*;
import rzh.smartsducationsystem.service.WorkService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkDao workDao;
    @Autowired
    TopicDao topicDao;
    @Autowired
    OptionDao optionDao;

    @Override
    public void createWork(String jsonData,Course course ,Teacher teacher) {
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        System.out.println(jsonObject.toString());
        String title = jsonObject.getString("title");
        String begin = jsonObject.getString("begin");
        String end=  jsonObject.getString("end");
        String limited = jsonObject.getString("limited");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Work work = BeanFactory.getWork();
        try {
            work.setCourse_Id(course.getId());
            work.setBegin(format.parse(begin));
            work.setEnd(format.parse(end));
            work.setLimited_Time(format.parse(limited));
            work.setJob_Num(teacher.getId());
            work.setName(teacher.getName());
            createWork(work);
        }catch (Exception e){
            e.printStackTrace();
        }
        String topic = jsonObject.getString("topic");
        JSONArray jsonArray = JSONArray.fromObject(topic);
        System.out.println(jsonArray.toString());
        String arr[] = new String[jsonArray.size()];
        JSONArray array[] = new JSONArray[jsonArray.size()];
        for (int i = 0 ; i < jsonArray.size(); i++ ){
            arr[i] = jsonArray.getString(i);
            System.out.println(arr[i]);
            array[i] = JSONArray.fromObject(arr[i]);
            Topic topic1 = BeanFactory.getTopic();
            topic1.setTopic_content(array[i].getString(1));
            topic1.setAnswer(array[i].getString(2));
            topic1.setExam_Id(work.getId());
            createTopic(topic1);
            List<Option> options = new ArrayList<>();
            for (int j = 2 ; j < array[i].size();j++){
                JSONObject object = JSONObject.fromObject(array[i].getJSONObject(j));
                Option option = BeanFactory.getOption();
                option.setOption(object.getString("top"));
                option.setOption_content(object.getString("content"));
                option.setTopic_Id(topic1.getId());
                System.out.println(option.toString());
                createOption(option);
                options.add(option);
            }
            topic1.setOptions(options);
            topicDao.updateTopicById(topic1);
        }
    }

    private void createTopic(Topic topic){
        topicDao.insertTopic(topic);
    }

    private void createWork(Work work){
        workDao.insertWork(work);
    }

    private void createOption(Option option){
        optionDao.insertOption(option);
    }
}
