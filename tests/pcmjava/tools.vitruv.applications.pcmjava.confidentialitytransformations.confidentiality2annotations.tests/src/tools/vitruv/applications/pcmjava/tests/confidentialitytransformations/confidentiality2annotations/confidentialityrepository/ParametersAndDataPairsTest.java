package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import java.util.List;
import java.util.Set;

import org.emftext.language.java.members.EnumConstant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import edu.kit.kastel.scbs.confidentiality.repository.ParametersAndDataPair;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;

public class ParametersAndDataPairsTest extends ConfidentialityTest {

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    public void testAddParametersAndDataPair() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddPudPairWithEmptyName() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPairWithName("");
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddPudPairWithNullName() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPairWithName(null);
        checkPuDPair(pudPair);
    }

    @Test
    public void testRenamePuDPair() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.setName(ConfElementsCreator.RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testRenamePuDPairWithEmptyName() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.setName("");
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testRenamePuDPairWithNullName() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.setName(null);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddParameterSource() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.getParameterSources().add(ConfElementsCreator.createParameterSource());
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testDeleteParameterSource() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        String parameterSource = ConfElementsCreator.createParameterSource();
        pudPair.getParameterSources().add(parameterSource);
        saveAndSynchronizeChanges(getRootElement());
        pudPair.getParameterSources().remove(parameterSource);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testChangeParameterSource() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        String parameterSource = ConfElementsCreator.createParameterSource();
        pudPair.getParameterSources().add(parameterSource);
        saveAndSynchronizeChanges(getRootElement());
        final int idx = pudPair.getParameterSources().indexOf(parameterSource);
        pudPair.getParameterSources().remove(parameterSource);
        pudPair.getParameterSources().add(idx, ConfElementsCreator.createParameterSource());
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testChangeOneOfMultipleParameterSources() throws Throwable {
        final List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        final ParametersAndDataPair pudPair = pudPairs.get(2);

        final List<String> parameterSources = ConfElementsCreator.createParameterSources(2);
        for (final String parameterSource : parameterSources) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        final String toChange = ConfElementsCreator.createParameterSource();
        pudPair.getParameterSources().add(toChange);
        saveAndSynchronizeChanges(getRootElement());

        final List<String> parameterSources2 = ConfElementsCreator.createParameterSources(2);
        for (final String parameterSource : parameterSources2) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }

        final int idx = pudPair.getParameterSources().indexOf(toChange);
        pudPair.getParameterSources().remove(toChange);
        pudPair.getParameterSources().add(idx, ConfElementsCreator.createParameterSource());
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
        checkPuDPairs(pudPairs);
    }

    @Test
    public void testAddMultipleParameterSources() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        List<String> parameterSources = ConfElementsCreator.createSimpleParameterSources();
        for (String parameterSource : parameterSources) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddAndDeleteMultipleParameterSources() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        List<String> parameterSources = ConfElementsCreator.createSimpleParameterSources();
        for (String parameterSource : parameterSources) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (String parameterSource : parameterSources) {
            pudPair.getParameterSources().remove(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddAndDeleteMultipleParameterSourcesNonMonotone() throws Throwable {
        final List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        final ParametersAndDataPair pudPair = pudPairs.get(2);

        final List<String> parameterSources = ConfElementsCreator.createParameterSources(2);
        for (final String parameterSource : parameterSources) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        final List<String> toRemove = ConfElementsCreator.createParameterSources(2);
        for (final String parameterSource : toRemove) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (final String parameterSource : toRemove) {
            pudPair.getParameterSources().remove(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        final List<String> parameterSources2 = ConfElementsCreator.createParameterSources(2);
        for (final String parameterSource : parameterSources2) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
        checkPuDPairs(pudPairs);
    }

    @Test
    public void testAddDataSetArgument() throws Throwable {
        DataSet dataSet = addDataSet();
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.getDataTargets().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testDeleteDataSetArgument() throws Throwable {
        DataSet dataSet = addDataSet();
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.getDataTargets().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        pudPair.getDataTargets().remove(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testChangeDataSetArgument() throws Throwable {
        DataSet dataSet = addDataSet();
        DataSet dataSet2 = addDataSet();
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.getDataTargets().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        final int idx = pudPair.getDataTargets().indexOf(dataSet);
        pudPair.getDataTargets().remove(dataSet);
        pudPair.getDataTargets().add(idx, dataSet2);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
    }

    @Test
    public void testChangeOneOfMultipleDataSetArguments() throws Throwable {
        final List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        final ParametersAndDataPair pudPair = pudPairs.get(2);

        final List<DataSet> dataSets = addDataSets(2);
        for (final DataSet dataSet : dataSets) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        DataSet toChange = addDataSet();
        DataSet newDataSet = addDataSet();
        pudPair.getDataTargets().add(toChange);
        saveAndSynchronizeChanges(getRootElement());

        final List<DataSet> dataSets2 = addDataSets(2);
        for (final DataSet dataSet : dataSets2) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }

        final int idx = pudPair.getDataTargets().indexOf(toChange);
        pudPair.getDataTargets().remove(toChange);
        pudPair.getDataTargets().add(idx, newDataSet);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPair(pudPair);
        checkPuDPairs(pudPairs);
    }

    @Test
    public void testAddMultipleDataSetArguments() throws Throwable {
        final ParametersAndDataPair pudPair = addPuDPair();
        final List<DataSet> dataSets = addDataSets(5);
        for (final DataSet dataSet : dataSets) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddAndDeleteMultipleDataSetArguments() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        final List<DataSet> dataSets = addDataSets(5);
        for (DataSet dataSet : dataSets) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (DataSet dataSet : dataSets) {
            pudPair.getDataTargets().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
    }

    @Test
    public void testAddAndDeleteMultipleDataSetArgumentsNonMonotone() throws Throwable {
        final List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        final ParametersAndDataPair pudPair = pudPairs.get(2);

        final List<DataSet> dataSets = addDataSets(2);
        for (final DataSet dataSet : dataSets) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        final List<DataSet> toRemove = addDataSets(2);
        for (final DataSet dataSet : toRemove) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (final DataSet dataSet : toRemove) {
            pudPair.getDataTargets().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        final List<DataSet> dataSets2 = addDataSets(2);
        for (final DataSet dataSet : dataSets2) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
        checkPuDPairs(pudPairs);
    }

    @Test
    public void testAddParameterSourcesAndDataSetArguments() throws Throwable {
        final ParametersAndDataPair pudPair = addPuDPair();
        final List<DataSet> dataSets = addDataSets(5);
        for (final DataSet dataSet : dataSets) {
            pudPair.getDataTargets().add(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        List<String> parameterSources = ConfElementsCreator.createComplexParameterSources();
        for (String parameterSource : parameterSources) {
            pudPair.getParameterSources().add(parameterSource);
            saveAndSynchronizeChanges(getRootElement());
        }
        checkPuDPair(pudPair);
    }

    @Test
    public void testDeletePuDPair() throws Throwable {
        ParametersAndDataPair pudPair = addPuDPair();
        getRootElement().getParametersAndDataPairs().remove(pudPair);
        saveAndSynchronizeChanges(getRootElement());
        ConfAssertions.assertEmptyCorrespondences(pudPair, correspondences().emptyCorrespondences(pudPair));
    }

    @Test
    public void testAddMultiplePuDPairs() throws Throwable {
        List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        checkPuDPairs(pudPairs);
    }

    @Test
    public void testAddAndDeleteMultiplePuDPairs() throws Throwable {
        List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        for (ParametersAndDataPair pudPair : pudPairs) {
            getRootElement().getParametersAndDataPairs().remove(pudPair);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (final ParametersAndDataPair pudPair : pudPairs) {
            ConfAssertions.assertEmptyCorrespondences(pudPair, correspondences().emptyCorrespondences(pudPair));
        }
    }

    @Test
    public void testAddAndDeleteMultiplePuDPairsNonMonotone() throws Throwable {
        final int amount = 5;
        final int amountToRemove = 3;
        final int amountToAddLater = 4;
        // create
        List<ParametersAndDataPair> pudPairs = addPuDPairs(amount);
        List<ParametersAndDataPair> toRemove = addPuDPairs(amountToRemove);
        // delete
        for (final ParametersAndDataPair pudPair : toRemove) {
            getRootElement().getParametersAndDataPairs().remove(pudPair);
            saveAndSynchronizeChanges(getRootElement());
        }
        // create again
        List<ParametersAndDataPair> toAddLater = addPuDPairs(amountToAddLater);
        checkPuDPairs(pudPairs);
        checkPuDPairs(toAddLater);
        for (final ParametersAndDataPair pudPair : toRemove) {
            ConfAssertions.assertEmptyCorrespondences(pudPair, correspondences().emptyCorrespondences(pudPair));
        }
    }

    @Test
    public void testRenameOneOfMultiplePuDPairs() throws Throwable {
        List<ParametersAndDataPair> pudPairs = addPuDPairs(3);
        ParametersAndDataPair toRename = addPuDPair();
        toRename.setName(ConfElementsCreator.RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkPuDPairs(pudPairs);
        checkPuDPair(toRename);
    }

    @Test
    public void testAddDataSetAndItsArgument() throws Throwable {
        DataSet dataSet = ConfElementsCreator.createDataSet();
        getRootElement().getDataIdentifier().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        ParametersAndDataPair pudPair = addPuDPair();
        pudPair.getDataTargets().add(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        final Set<EnumConstant> corresponding = correspondences().getCorrespondingEnumConstants(dataSet);
        EnumConstant enumConstant = ConfAssertions.getSingleObject(corresponding);
        ConfAssertions.assertEqualDataSets(dataSet, enumConstant);
        checkPuDPair(pudPair);
    }
}
