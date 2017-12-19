package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.emftext.language.java.members.EnumConstant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplicationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;

public class DataSetsTest extends ConfidentialityApplicationTest {

    private final static String DATASET_RENAME = "rename";

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    public void testAddDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithEmptyName() throws Throwable {
        DataSet dataSet = addDataSetWithName("");
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithNullName() throws Throwable {
        DataSet dataSet = addDataSetWithName(null);
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithEmptyId() throws Throwable {
        DataSet dataSet = addDataSetWithId("");
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithNullId() throws Throwable {
        DataSet dataSet = addDataSetWithId(null);
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName(DATASET_RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSetWithEmptyName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName("");
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSetWithNullName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName(null);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(ConfElementsCreator.getId());
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdDataSetWithNullId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(null);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdDataSetWithEmptyId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId("");
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdAndName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(ConfElementsCreator.getId());
        saveAndSynchronizeChanges(getRootElement());
        dataSet.setName(DATASET_RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testDeleteDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        getRootElement().getDataIdentifier().remove(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
    }

    @Test
    public void testAddMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(3);
        checkDataSets(dataSets);
    }

    @Test
    public void testAddAndDeleteMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(5);
        for (DataSet dataSet : dataSets) {
            getRootElement().getDataIdentifier().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (final DataSet dataSet : dataSets) {
            ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
        }
    }

    @Test
    public void testAddAndDeleteMultipleDataSetsNonMonotone() throws Throwable {
        final int amount = 5;
        final int amountToRemove = 3;
        final int amountToAddLater = 4;
        // create
        List<DataSet> toRemove = addDataSets(amountToRemove);
        List<DataSet> dataSets = addDataSets(amount);
        // delete
        for (final DataSet dataSet : toRemove) {
            getRootElement().getDataIdentifier().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        // create again
        List<DataSet> toAddLater = addDataSets(amountToAddLater);
        checkDataSets(dataSets);
        checkDataSets(toAddLater);
        for (final DataSet dataSet : toRemove) {
            ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
        }
    }

    @Test
    public void testRenameOneOfMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(3);
        DataSet toRename = addDataSet();
        toRename.setName(DATASET_RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSets(dataSets);
        checkDataSet(toRename);
    }

    private DataSet addDataSet() throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    private DataSet addDataSetWithName(String name) throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        dataSet.setName(name);
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    private DataSet addDataSetWithId(String id) throws IOException {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        dataSet.setId(id);
        addSaveAndSynchronize(dataSet);
        return dataSet;
    }

    private void addSaveAndSynchronize(DataSet dataSet) throws IOException {
        getRootElement().getDataIdentifier().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
    }

    private List<DataSet> addDataSets() throws IOException {
        return addDataSets(Optional.empty());
    }

    private List<DataSet> addDataSets(int amount) throws IOException {
        return addDataSets(Optional.of(amount));
    }

    private List<DataSet> addDataSets(Optional<Integer> amount) throws IOException {
        List<DataSet> dataSets;
        if (amount.isPresent()) {
            dataSets = ConfElementsCreator.createDataSets(amount.get());
        } else {
            dataSets = ConfElementsCreator.createDataSets(3);
        }
        for (DataSet dataSet : dataSets) {
            getRootElement().getDataIdentifier().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        return dataSets;
    }

    private void checkDataSet(DataSet dataSet) {
        final Set<EnumConstant> corresponding = correspondences().getCorrespondingEnumConstants(dataSet);
        EnumConstant enumConstant = ConfAssertions.getSingleObject(corresponding);
        ConfAssertions.assertEqualDataSets(dataSet, enumConstant);
    }

    private void checkDataSets(Iterable<DataSet> dataSets) {
        for (DataSet dataSet : dataSets) {
            checkDataSet(dataSet);
        }
    }
}
